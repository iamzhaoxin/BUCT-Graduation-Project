package buct.budgetsystem.util;

import buct.budgetsystem.pojo.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/9 17:15
 */
public class ExcelUtil {
    public static List<User> excelToUserList(String fileType, InputStream inputStream) throws IOException, ParseException {
        Workbook workbook;
        if(".xls".equals(fileType)){
            workbook=new HSSFWorkbook(inputStream);
        }else{
            workbook=new XSSFWorkbook(inputStream);
        }
        List<User> userList = new LinkedList<>();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 开始解析Excel
        Sheet sheet = workbook.getSheetAt(0);
        //第一行是列名，所以不读
        int firstRowIndex = sheet.getFirstRowNum()+1;
        int lastRowIndex = sheet.getLastRowNum();
        //遍历行
        for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
            Row row = sheet.getRow(rIndex);
            if (row != null) {
                int index=0;
                User user = new User();
                user.setUserId(row.getCell(index++).toString());
                user.setUserName(row.getCell(index++).toString());
                user.setUserPassword(passwordEncoder.encode(row.getCell(index++).toString()));
                user.setUserNameReal(row.getCell(index++).toString());
                DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
                Date date= fmt.parse(row.getCell(index++).toString());
                user.setUserBirthdate(date);
                user.setUserSex(row.getCell(index++).toString());
                user.setUserCellphone(row.getCell(index++).toString());
                user.setUserEmail(row.getCell(index++).toString());
                user.setUnitId(row.getCell(index++).toString());
                user.setUnitName(row.getCell(index++).toString());
//                user.setRoleId(Integer.parseInt(row.getCell(index).toString()));
                user.setRoleId(Double.valueOf((row.getCell(index).toString())).intValue());
                userList.add(user);
            }
        }
        return userList;
    }
}
