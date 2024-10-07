import java.time.LocalDateTime;

public class Registry implements Comparable<Registry>
{
    private final String author;
    private String content;
    private Integer likes = 0;
    private final LocalDateTime created = LocalDateTime.now();
    private LocalDateTime edited = LocalDateTime.now();
    public Registry(String author, String content)
    {
        this.author = author;
        this.content = content;
    }

    public String getAuthor()
    {
        return author;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
        this.edited = LocalDateTime.now();
    }
    public int getLikes()
    {
        return likes;
    }
    public LocalDateTime getCreated()
    {
        return created;
    }
    public LocalDateTime getEdited()
    {
        return edited;
    }
    public void like()
    {
        this.likes += 1;
    }

    @Override
    public String toString() {
        return  author + " - " + likes + " - " + created + '\'' +
                ((this.created.isBefore(this.edited)) ? ", Szerkesztve=" + edited + '\'' : '\'')
                + content;
    }

    @Override
    public int compareTo(Registry o) {
        return this.likes.compareTo(o.likes);
    }
}
