package kt.com.membership.controller;

import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.JsonErrorResponse;
import kt.com.membership.exception.AlreadySignupMembership;
import kt.com.membership.exception.DuplicateUserException;
import kt.com.membership.exception.InvalidPasswordException;
import kt.com.membership.exception.InvalidUserIdException;
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

    @ExceptionHandler(AlreadySignupMembership.class)
    public JsonErrorResponse alreadySignupMembershipException(){
        return new JsonErrorResponse(API_STATUS.BAD_REQUEST,"멤버십에 이미 가입 되었습니다.");
    }

}
