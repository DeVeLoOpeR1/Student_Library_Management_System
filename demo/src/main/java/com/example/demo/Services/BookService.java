package com.example.demo.Services;

import com.example.demo.RequestDto.BookDto;
import com.example.demo.RequestDto.BookIdDto;
import com.example.demo.RequestDto.BookIssueDto;
import com.example.demo.RequestDto.BookSubmitDto;
import com.example.demo.Enums.Status;
import com.example.demo.Enums.Type;
import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Models.Card;
import com.example.demo.Models.Transaction;
import com.example.demo.Repositories.AuthorRepository;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Repositories.CardRepository;
import com.example.demo.Repositories.TransactionRepository;
import com.example.demo.ResponseDto.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public String addBook(BookDto bookDto) {

        try{


            //create new book object and set the required data that we can be able to set
            Book book = new Book();
            book.setName(bookDto.getName());
            book.setWriter(bookDto.getWriter());
            book.setGenre(bookDto.getGenre());

            // get the author entity with the help of the author id
            Author author = authorRepository.findById(bookDto.getAuthorId()).get();
            //now set the author entity to the book
            book.setAuthor(author);

            bookRepository.save(book);

            return "Book Added Successfully";

        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return "Book not added please try again later";
    }

    public String issueBook(BookIssueDto bookIssueDto) {

        //because a transaction should be record in evey case whether the transacction is success and failed
        Transaction transaction = new Transaction();
        try{

            int cardId = bookIssueDto.getCardId();
            int bookId = bookIssueDto.getBookId();

            //set the transaction and create one new transaction

            Status status = Status.valueOf("SUCCESS");
            Type type = Type.valueOf("ASSIGN");
            transaction.setStatus(status);
            transaction.setType(type);


            Card card = cardRepository.findById(cardId).get();
            transaction.setCard(card); //if in case there is problem in book entity so alleast we can get one of them
            Book book = bookRepository.findById(bookId).get();
            transaction.setBook(book);



            // now we need to set the book card foreign key by giving the card entity to the book table
            book.setCard(card);
            List<Book> bookList = card.getIssued();
            bookList.add(book); //new book issued to the student card id
            card.setIssued(bookList); //assigned back to the card

            //book transaction related to it
            List<Transaction> transactionListBook = book.getTransaction();
            transactionListBook.add(transaction);
            book.setTransaction(transactionListBook);

            //card transaction
            List<Transaction> transactionListCard = card.getTransactions();
            transactionListCard.add(transaction);
            card.setTransactions(transactionListCard);


            // now save the changes card -->child-->book-->child -->transaction will be saved automatically
            // because of the cascade effect from parent --> child classs

            cardRepository.save(card);

            System.out.println("book assigned");

            return "Book Issued Successfully book id "+book.getId()+" "+book.getName();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        transaction.setStatus(Status.FAILED);
        transactionRepository.save(transaction); //in case of success or failed transaction must be saved
        return "Book not issued please try again later";


    }

    public String submitBook(BookSubmitDto bookSubmitDto) {

        int bookId = bookSubmitDto.getBookId();

        Book book = bookRepository.findById(bookId).get(); // get the book object

        int cardId= book.getCard().getId(); // get card obj associated with the book
        Card card = cardRepository.findById(cardId).get(); // get the object there
        //create a transaction for book submit

        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setBook(book);
        transaction.setType(Type.SUBMIT);
        transaction.setStatus(Status.SUCCESS);
        //transaction is all attribute is set to go

        book.setCard(null);
        System.out.println(book.getCard()+" book card after set it value back");
        System.out.println("size of the book list we have "+card.getIssued().size());
        card.getIssued().remove(book);
        System.out.println("AFTER size of the book list we have "+card.getIssued().size());

        // set the list of the transaction in book
        System.out.println("BEFORE size of the book transaction list we have "+book.getTransaction().size());
        book.getTransaction().add(transaction);
        System.out.println("AFTER size of the book transaction list we have "+book.getTransaction().size());

        //IT GET ERROR WHEN SAME TRANSACTION IS REFERED TO CARD ALSO
        // set the list of the transaction in the card
//        System.out.println("BEFORE size of the transaction list we have "+ card.getTransactions().size());
//        card.getTransactions().add(transaction);
//        System.out.println("AFTER size of the transaction list we have "+ card.getTransactions().size());

        //due to cascade effect book and transaction will get saved automatically
        cardRepository.save(card);

        return "Book return success";
    }

    public BookResponseDto getBook(BookIdDto bookIdDto) {
        // get the book obj with the use of bookId
        Book book = bookRepository.findById(bookIdDto.getId()).get();

        // convert the ( book object ---> book response dto )
        //first create a new response dto obj
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setWriter(book.getWriter());
        bookResponseDto.setGenre(book.getGenre());
        bookResponseDto.setAuthorId(book.getAuthor().getId());

        return bookResponseDto;
    }
}
