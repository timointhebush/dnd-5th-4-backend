package dnd.team4backend.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dnd.team4backend.controller.form.UserForm;
import dnd.team4backend.domain.Dress;
import dnd.team4backend.domain.User;
import dnd.team4backend.domain.vo.BasicResponseEntity;
import dnd.team4backend.domain.vo.UserResponse;
import dnd.team4backend.domain.vo.UserResponseEntity;
import dnd.team4backend.service.UserService;
import dnd.team4backend.service.assembler.UserAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String isOurMember(@RequestParam String userId) {
        User user = userService.findOne(userId);
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
    public String isExistedNickName(@RequestParam String name) {
        boolean isExistNickName = userService.isExistedNickName(name);

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
    public String userDressList(@RequestParam String userId) {
        User user = userService.findOne(userId);
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

    @GetMapping(value = "user/{id}")
    public ResponseEntity showUserInfo(@PathVariable("id") String userId) {
        User user = userService.findOne(userId);
        if (user == null) {
            BasicResponseEntity responseEntity = new BasicResponseEntity(400, "해당하는 id의 회원이 존재하지 않습니다.");
            return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
        }

        try {
            UserResponse userResponse = UserAssembler.toDto(user);
            UserResponseEntity responseEntity = new UserResponseEntity(200, "해당 id의 유저 정보를 성공적으로 조회하였습니다.", userResponse);
            return new ResponseEntity(responseEntity, HttpStatus.OK);
        } catch (IllegalStateException e) {
            BasicResponseEntity responseEntity = new BasicResponseEntity(400, e.getMessage());
            return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping(value = "user/{id}")
    public ResponseEntity updateName(@PathVariable("id") String userId, @RequestBody UserForm userForm) {
        boolean isExisted = userService.isExistedNickName(userForm.getName());
        if (!isExisted) {
            userService.updateName(userId, userForm.getName());
            UserResponse userResponse = UserAssembler.toDto(userService.findOne(userId));
            UserResponseEntity responseEntity = new UserResponseEntity(200, "해당 유저의 닉네임을 성공적으로 변경하였습니다.", userResponse);
            return new ResponseEntity(responseEntity, HttpStatus.OK);
        } else {
            BasicResponseEntity responseEntity = new BasicResponseEntity(400, "해당 닉네임이 이미 존재합니다.");
            return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
        }
    }
}
