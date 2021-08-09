package dnd.team4backend.controller;

import com.google.gson.JsonObject;
import dnd.team4backend.controller.form.DressForm;
import dnd.team4backend.controller.form.UserForm;
import dnd.team4backend.domain.Dress;
import dnd.team4backend.domain.User;
import dnd.team4backend.repository.UserRepository;
import dnd.team4backend.service.DressService;
import dnd.team4backend.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class DressController {
    private final DressService dressService;
    private final UserService userService;
    private final UserRepository userRepository;

    public DressController(DressService dressService, UserService userService, UserRepository userRepository) {
        this.dressService = dressService;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @DeleteMapping(value = "dress/{id}")
    public String deleteDress(@RequestBody UserForm userForm, @PathVariable("id") Long dressId) {
        String userId = userForm.getUserId();
        if (userRepository.findOne(userId) == null) {
            JsonObject obj = new JsonObject();
            obj.addProperty("status", 400);
            obj.addProperty("msg", "해당하는 id의 회원이 존재하지 않습니다.");

            return obj.toString();
        }
        try {
            dressService.deleteDress(dressId);
            JsonObject obj = new JsonObject();
            obj.addProperty("status", 200);
            obj.addProperty("msg", "옷 삭제 완료");
            return obj.toString();

        } catch (DataIntegrityViolationException e) {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 400);
            obj.addProperty("msg", "다른 평가에 옷이 등록되어있어서 옷을 삭제할 수 없습니다.");

            return obj.toString();
        }

    }

    @PostMapping(value = "dress")
    public String saveDress(@RequestBody DressForm dressForm) {
        try {
            User user = userService.findOne(dressForm.getUserId());
            Dress dress = Dress.createDress(user, dressForm.getDressName(), dressForm.getDressType());
            dressService.saveDress(dress);

            JsonObject obj = new JsonObject();
            obj.addProperty("status", 200);
            obj.addProperty("msg", "옷 등록 완료");

            JsonObject data = new JsonObject();
            data.addProperty("userId", dressForm.getUserId());
            data.addProperty("dressName", dressForm.getDressName());
            data.addProperty("dressType", String.valueOf(dressForm.getDressType()));
            obj.add("data", data);

            return obj.toString();

        } catch (Exception e) {
            JsonObject obj = new JsonObject();
            obj.addProperty("status", 400);
            obj.addProperty("msg", "옷이 등록되지 않았습니다.");
            return obj.toString();
        }

    }

}
