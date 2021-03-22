package com.ahanab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String uname = req.getParameter("uname");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String cfPassword  = req.getParameter("cfPassword");


        Map<String,String> messages = new HashMap<>();
        Map<String,String> userInfo = new HashMap<>();

        userInfo.put("fname",fname);
        userInfo.put("lname",lname);
        userInfo.put("uname",uname);
        userInfo.put("email",email);
        userInfo.put("address",address);
        userInfo.put("password",password);


        req.setAttribute("messages",messages);
        req.setAttribute("userInfo",userInfo);

        //First name validation
        if(fname.equals(""))
        {
            messages.put("fname","First Name required.");
        }
        else if(fname.length()<3 || fname.length()>12)
        {
            messages.put("fname","Must contain 3-12 characters.");
        }


        //Last name validation
        if(fname.equals(""))
        {
            messages.put("lname","Last Name required.");
        }
        else if(lname.length()<3 || lname.length()>12)
        {
            messages.put("lname","Must contain 3-12 characters.");
        }

        //User name validation
        if(uname.equals(""))
        {
            messages.put("uname","User Name required.");
        }
        else if(uname.length()<3 || uname.length()>12)
        {
            messages.put("uname","Must contain 3-12 characters.");
        }
        else
        {
            boolean isContainDigit = false;

            for(int i=0; i<uname.length(); i++)
            {
                if((int)uname.charAt(i)>=48 && (int)uname.charAt(i)<=57)
                {
                    isContainDigit = true;
                    break;
                }
            }

            if(!isContainDigit)
            {
                messages.put("uname","Must Contain a number.");
            }
        }

        //Email validation
        if(email.equals(""))
        {
            messages.put("email","Email Required.");
        }

        //Address validation
        if(address.equals(""))
        {
            messages.put("address","Address Required.");
        }

        //password validation
        if(password.equals(""))
        {
            messages.put("password","Password Required.");
        }
        else if(password.length()<6)
        {
            messages.put("password","Minimum 6 characters required");
        }
        else
        {
            boolean isContainSpecial = false;

            for(int i=0; i<password.length(); i++)
            {
                if(((int)password.charAt(i)>=35 && (int)password.charAt(i)<=38) || (int)password.charAt(i)==64)
                {
                    isContainSpecial = true;
                    break;
                }
            }

            if(!isContainSpecial)
            {
                messages.put("password","Must Contain a special character.");
            }
        }

        //Confirm password validation
        if(cfPassword.equals(""))
        {
            messages.put("cfPassword","Please confirm password");
        }
        else if(!password.equals(cfPassword))
        {
            messages.put("cfPassword", "Must be same as password");
        }


        if(messages.isEmpty())
        {
            req.setAttribute("success","Successfully Submitted.");
            req.removeAttribute("userInfo");
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }

}
