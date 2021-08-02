package dnd.team4backend.controller;

import com.google.gson.JsonObject;
import dnd.team4backend.domain.Dress;
import dnd.team4backend.domain.User;
import dnd.team4backend.service.DressService;
import dnd.team4backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DressController {
    private final DressService dressService;
    private final UserService userService;

    public DressController(DressService dressService, UserService userService) {
        this.dressService = dressService;
        this.userService = userService;
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
