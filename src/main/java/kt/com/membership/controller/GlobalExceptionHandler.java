package kt.com.membership.controller;

import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.JsonErrorResponse;
import kt.com.membership.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * Binding Input Exception
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonErrorResponse invalidInputException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"입력값이 잘못되었습니다.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonErrorResponse invalidJsonException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"입력값이 잘못되었습니다.");
    }

    /**
     * User Exception
     */
    @ExceptionHandler(DuplicateUserException.class)
    public JsonErrorResponse duplicateUserException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"이미 가입된 아이디입니다.");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public JsonErrorResponse dataIntegrityViolationException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"입력값이 잘못되었습니다.");
    }

    @ExceptionHandler(InvalidUserIdException.class)
    public JsonErrorResponse invalidUserIdException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"가입되지 않은 아이디입니다.");
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public JsonErrorResponse invalidPasswordException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"비밀번호가 틀립니다.");
    }

    /**
     * Membership
     * */
    @ExceptionHandler(AlreadySignupMembership.class)
    public JsonErrorResponse alreadySignupMembershipException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"멤버십에 이미 가입 되었습니다.");
    }

    @ExceptionHandler(NotMembershipUser.class)
    public JsonErrorResponse notMembershipUserException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"멤버십에 가입되지 않은 유저입니다.");
    }

    @ExceptionHandler(NoAvailableChoiceCount.class)
    public JsonErrorResponse noAvailableChoiceCount(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"잔여 횟수가 없습니다.");
    }
    @ExceptionHandler(NoAvailablePoint.class)
    public JsonErrorResponse noAvailablePoint(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"사용가능 포인트가 부족합니다.");
    }

    /**
     * Item
     * */
    @ExceptionHandler(DuplicateItemException.class)
    public JsonErrorResponse duplicateItemException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST, "중복된 아이템입니다.");
    }

    @ExceptionHandler(InvalidItemException.class)
    public JsonErrorResponse invalidItemException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST, "존재하지 않는 아이템입니다.");
    }

}
