package ru.votingsystem.web.rest.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.votingsystem.service.VoteService;
import ru.votingsystem.to.VoteTo;

import java.util.List;

import static ru.votingsystem.util.VoteUtil.createNewFromVote;

@RestController
@RequestMapping(value = AdminVoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminVoteController {

    private final VoteService voteService;

    static final String REST_URL = "/admin/votes";

    @Autowired
    public AdminVoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{voteId}")
    public VoteTo get(@PathVariable int voteId) {
        return createNewFromVote(voteService.get(voteId));
    }

    @GetMapping(value = "/today")
    public List<VoteTo> getTodayVotes() {
        return createNewFromVote(voteService.getTodayVotes());
    }

    @GetMapping
    public List<VoteTo> getAll() {
        return createNewFromVote(voteService.getAll());
    }

    @DeleteMapping("/{voteId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int voteId) {
        voteService.delete(voteId);
    }
}