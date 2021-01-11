package com.servlet;

import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchStudentServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //发sql语句查询学生的信息  -- （使用for循环查询到的数据做模拟）
        HashMap<Integer, Student> studentList = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            studentList.put(i+1, new Student(i+1, "name"+(i+1), 18+i, "phone"+i));
        }
        //保存查询到结果（学生信息）到request域中
        String[] ids = req.getParameterValues("id");
        List<Student> result = new ArrayList<>();
        for(String strId: ids){
            int id = Integer.parseInt(strId);
            Student student = studentList.get(id);
            if(student != null){
                result.add(student);
            }
        }
        req.setAttribute("resultOfStudent", result);

        //请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/practice/showStudent.jsp").forward(req, resp);
    }
}
