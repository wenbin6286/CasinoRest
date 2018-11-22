package com.twm.casino.rest;

import com.twm.casino.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasinoCtrl {
    private static ICasino casino = new Casino(5);

    @GetMapping(path="/casino")
    public ICasino getCasino() {
        return casino;
    }

    @GetMapping(path="/open")
    public ICasino openCasino() {
        casino.open();
        return casino;
    }
    @GetMapping(path="/play")
    public IPlayer playGame(@RequestParam(value="initialBalance",defaultValue="10")int initialBalance,
                            @RequestParam(value = "numGame",defaultValue="3") int numGame) {
        IPlayer player = new Player(initialBalance,new RPSStrategy());
        casino.enter(player, numGame);
        return player;
    }

}
