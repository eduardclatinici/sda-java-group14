package com.sda.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    //field injection
    //notice that if we use the @Autowired annotation on field or on setter we don't need to add the dependencies
    // in the constructor of TextEditor class as parameters because Spring has another way of injecting
    // the required dependency
    @Autowired
    private TextFormatter textFormatter;

    private SpellChecker spellChecker;

    private ImageConverter imageConverter;

    //setter injection
    @Autowired
    public void setImageConverter(ImageConverter converter) {
        this.imageConverter = converter;
    }

    //constructor injection
    //try to remove the @Autowired annotation and see if it still works
    //from Spring 4.3 we don't need to actually specify the @Autowired annotation
    //on constructors that inject beans as this is the Spring recommended way of injecting dependencies
    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    //delegation
    public void spellCheck() {
        this.spellChecker.checkSpelling();
    }

    public void format() {
        this.textFormatter.format();
    }

    public void convertImage() {
        imageConverter.convert();
    }
}
