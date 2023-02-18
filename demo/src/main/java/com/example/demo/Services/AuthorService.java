package com.example.demo.Services;

import com.example.demo.RequestDto.AuthorDto;
import com.example.demo.Models.Author;
import com.example.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(AuthorDto authorDto) {

        // create a new author object and here it can be the most thing
        Author author = new Author();
        // set all the attribute of the author entity that we can able to set
        author.setName(authorDto.getName());
        author.setAddress(authorDto.getAddress());
        author.setMobNo(authorDto.getMobNo());
        author.setRating(authorDto.getRating());

        // now the author all the possible attribute is updated which we can
        // now all the attribute is set and we are set save the author entity

        authorRepository.save(author);

        return "Author is created successfully";
    }
}
