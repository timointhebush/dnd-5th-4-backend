package dnd.team4backend.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dnd.team4backend.controller.form.UserForm;
import dnd.team4backend.domain.Dress;
import dnd.team4backend.domain.User;
import dnd.team4backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user")
    public String isOurMember(@RequestBody UserForm userForm) {
        User user = userService.findOne(userForm.getUserId());
        if (user == null) {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 200);
            obj.addProperty("isOurMember", false);
            obj.addProperty("msg", "해당 id의 회원이 존재하지 않습니다.");

            return obj.toString();

        } else {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 200);
            obj.addProperty("isOurMember", true);
            obj.addProperty("msg", "이미 가입된 회원입니다.");

            return obj.toString();
        }
    }

    @GetMapping(value = "name")
    public String isExistedNickName(@RequestBody UserForm userForm) {
        boolean isExistNickName = userService.isExistedNickName(userForm.getName());

        if (!isExistNickName) {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 200);
            obj.addProperty("isExistNickName", false);
            obj.addProperty("msg", "해당 닉네임은 사용이 가능합니다.");

            return obj.toString();

        } else {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 200);
            obj.addProperty("isExistNickName", true);
            obj.addProperty("msg", "이미 사용하고 있는 닉네임입니다.");

            return obj.toString();
        }
    }


    @PostMapping(value = "user")
    public String signUp(@RequestBody UserForm userForm) {

        User user = new User();
        user.addBasicInfo(userForm.getUserId(), userForm.getName(), userForm.getGender(), userForm.getConstitution());
        try {
            userService.join(user);

            JsonObject obj = new JsonObject();

            obj.addProperty("status", 200);
            obj.addProperty("msg", "회원 등록 완료");

            JsonObject data = new JsonObject();

            data.addProperty("name", userForm.getName());
            data.addProperty("gender", userForm.getGender().toString());
            data.addProperty("constitution", userForm.getConstitution().toString());
            obj.add("data", data);

            return obj.toString();

        } catch (IllegalStateException e) {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 400);
            obj.addProperty("msg", e.getMessage());

            return obj.toString();
        }

    }

    @GetMapping(value = "user/dresses")
    public String userDressList(@RequestBody UserForm userForm) {
        User user = userService.findOne(userForm.getUserId());
        if (user == null) {
            JsonObject obj = new JsonObject();
            obj.addProperty("status", 400);
            obj.addProperty("msg", "해당하는 id의 회원이 존재하지 않습니다.");

            return obj.toString();
        }

        List<Dress> dressList = user.getDressList();
        try {
            JsonObject obj = new JsonObject();

            JsonArray jsonArray = new JsonArray();
            for (Dress dress : dressList) {
                JsonObject dressObject = new JsonObject();
                dressObject.addProperty("id", dress.getId());
                dressObject.addProperty("userId", dress.getUser().getId());
                dressObject.addProperty("name", dress.getDressName());
                dressObject.addProperty("type", dress.getDressType().toString());
                jsonArray.add(dressObject);
            }

            obj.add("dresses", jsonArray);
            obj.addProperty("status", 200);
            obj.addProperty("msg", "유저의 드레스리스트가 성공적으로 조회 되었습니다.");
            return obj.toString();

        } catch (IllegalStateException e) {
            JsonObject obj = new JsonObject();

            obj.addProperty("status", 400);
            obj.addProperty("msg", e.getMessage());

            return obj.toString();
        }


    }

}
