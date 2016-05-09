package com.imooc.common;

import com.imooc.object.User;

import java.beans.PropertyEditorSupport;

/**
 * Created by 59215_000 on 2016/5/9.
 */
public class MyPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        String[] testArray = text.split(",");
        user.setName(testArray[0]);
        user.setAge(Integer.valueOf(testArray[1]));
        this.setValue(user);
    }

    public static void main(String[] args) {
        MyPropertyEditor editor = new MyPropertyEditor();
        editor.setAsText("tom,22");
        System.out.println(editor.getValue());
    }
}
