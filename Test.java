package com.jiurui;

import java.util.ArrayList;

/**    
* @author zk  
* @date 2018年9月6日  
*/
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Student> list  = new ArrayList<>();
        list = new GetSource().getStudent();
        for (int i = 0; i < list.size(); i++) {
			
        		if (list.get(i)!=null)
        			new JdbcUtils().writeToMysql(list.get(i));
        }
	}

}
