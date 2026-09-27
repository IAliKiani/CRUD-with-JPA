package org.ali.model.common;

import org.ali.model.common.exepts.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ExceptionWrapper{
    public static String getError(Exception e) {
        if (e instanceof NotUpToDate) {
            return "418" + e.getMessage();
        }else if (e instanceof EmptyField){
            return "419" + e.getMessage();
        }else if (e instanceof ExistedPerson){
            return "420" + e.getMessage();
        }else if (e instanceof NotExceptLength){
            return "421" + e.getMessage();
        }else if (e instanceof NoRecord){
            return "422" + e.getMessage();
        }else if (e instanceof NotExistRecord){
            return "423" + e.getMessage();
        }else if (e instanceof NotLogicalAge){
            return "424" + e.getMessage();
        }else if (e instanceof NotLegalAge){
            return "425" + e.getMessage();
        }else if (e instanceof NotNumber){
            return "426" + e.getMessage();
        }else {
            return "unknown" + e.getMessage();
        }
    }
}
