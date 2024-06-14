package Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Setter
    @ManyToOne
    private Comment comment;

}
