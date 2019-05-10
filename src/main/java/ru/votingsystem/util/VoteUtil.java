package ru.votingsystem.util;

import ru.votingsystem.model.Vote;
import ru.votingsystem.to.VoteTo;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class VoteUtil {
    private static final LocalTime TIME = LocalTime.of(23, 30);

    public static void checkTime(LocalTime localTime) {
        if (localTime.isAfter(TIME)) {
            throw new IllegalArgumentException(localTime + " it's to late");
        }
    }

    public static VoteTo createNewFromVote(Vote vote) {
        return new VoteTo(vote.getId(), vote.getDate(),
                vote.getUser().getId(), vote.getRestaurant().getId());
    }

    public static List<VoteTo> createNewFromVote(List<Vote> votes) {
        return votes.stream().map(VoteUtil::createNewFromVote).collect(Collectors.toList());
    }
}