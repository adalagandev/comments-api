package com.antoniedalagan.technicalexam.commentsapi;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import com.antoniedalagan.technicalexam.commentsapi.service.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CommentsApiApplication   implements CommandLineRunner{
    private static final Logger LOG = LoggerFactory.getLogger(CommentsApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommentsApiApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(CommentsService commentsService) {
        Comment parent1 = new Comment(null, "Tell me a joke", "Jokenator43");
        Comment parent2 = new Comment(null, "What about some puns", "Punmaster");
        return args -> {
            commentsService.saveComment(new Comment(parent1, " My wife told me to stop impersonating a flamingo. I had to put my foot down. ", "IndianaGuy"));
            commentsService.saveComment(new Comment(parent1, " I went to buy some camo pants but couldn’t find any.","KeyboardProtector"));
            commentsService.saveComment(new Comment(parent1, " I was wondering why the frisbee kept getting bigger and bigger, but then it hit me.", "NoobHaxors"));
            commentsService.saveComment(new Comment(parent1, " Don’t you hate it when someone answers their own questions? I do.", "BBallExpert"));


            Comment c1 = new Comment(parent2, " I'm afraid for the calendar. Its days are numbered.", "Sherlock");
            Comment c2 = new Comment(c1, "My wife rolled here eyes on that one", "LockeLamora");
            Comment c3 = new Comment(c1, "That's because it is a genuide dad joke", "W-Hunting");
            commentsService.saveComment(new Comment(parent2, " I'm afraid for the calendar. Its days are numbered.", "Boromir"));

        };
    }

    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        LOG.info("Creating tables");
//
//        jdbcTemplate.execute("DROP TABLE COMMENTS IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE COMMENTS(" +
//                "COMMENT_ID SERIAL, COMMENT_TEXT VARCHAR(255), USER VARCHAR(255), PARENT_COMMENT_ID SERIAL)");

//        // Split up the array of whole names into an array of first/last names
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
//        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//        log.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> log.info(customer.toString()));
    }

}
