package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "healthmetrics")

public class healthmetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weigth", nullable = false)
    private float weigth;

    @Column(name = "height", nullable = false)
    private float height;

    @Column(name = "heartRate", nullable = false)
    private int heartRate;

}
