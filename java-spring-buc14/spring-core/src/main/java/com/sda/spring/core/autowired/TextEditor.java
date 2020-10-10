package com.sda.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

    //field injection
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
    @Autowired
    public TextEditor(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }

    //delegation
    public void spellCheck(){
        this.spellChecker.checkSpelling();
    }

    public void format(){
        this.textFormatter.format();
    }

    public void convertImage(){
        imageConverter.convert();
    }
}
