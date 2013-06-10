package br.com.tomcat.weld;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * User: rossmyt
 * Date: 28.01.2010
 * Time: 14:02:07
 */
@Entity
public class Book
{
	@Id
	@Column(name = "id")
    private Long id;

    private String name;
    private String author;
//    @Id
//    @SequenceGenerator(name="myseq",sequenceName="myseq", allocationSize=1)
//    @GeneratedValue(generator="myseq",strategy=GenerationType.IDENTITY)
//    @Column(name = "id")
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    @Column(name = "author")
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}