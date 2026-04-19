package pl.wsb.fitnesstracker.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.healthmetrics.HealthMetrics;
import pl.wsb.fitnesstracker.healthmetrics.HealthMetricsRepository;
import pl.wsb.fitnesstracker.statistics.api.Statistics;
import pl.wsb.fitnesstracker.statistics.api.StatisticsRepository;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserRepository;

import java.time.LocalDate;
import java.util.Date;

@Component
@Profile("loadInitialData")
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final StatisticsRepository statisticsRepository;
    private final HealthMetricsRepository healthMetricsRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) {
            return;
        }

        User user = userRepository.save(
                new User(
                        "Jan",
                        "Kowalski",
                        LocalDate.of(2000, 1, 15),
                        "jan.kowalski@example.com"
                )
        );

        trainingRepository.save(
                new Training(
                        user,
                        new Date(),
                        new Date(),
                        ActivityType.RUNNING,
                        5.5,
                        10.2
                )
        );

        statisticsRepository.save(
                new Statistics(
                        user,
                        1,
                        5.5,
                        350
                )
        );

        healthMetricsRepository.save(
                new HealthMetrics(
                        user,
                        LocalDate.now(),
                        78.5f,
                        180.0f,
                        72
                )
        );
    }
}