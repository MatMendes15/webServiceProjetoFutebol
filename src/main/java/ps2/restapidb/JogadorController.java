package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepo;

    @GetMapping("/api/jogadores")
    Iterable<Jogador> getJogadores() {
        return jogadorRepo.findAll();
    }

    @GetMapping("/api/jogadores/{id}")
    Optional<Jogador> getJogador(@PathVariable long id) {
        return jogadorRepo.findById(id);
    }

    @PostMapping("/api/jogadores")
    Jogador createJogador(@RequestBody Jogador jogador) {
        Jogador createdJogador = jogadorRepo.save(jogador);
        return createdJogador;
    }

    @PutMapping("/api/jogadores/{jogadorId}")
    Optional<Jogador> updateJogador(@RequestBody Jogador jogadorReq, @PathVariable long jogadorId) {
        Optional<Jogador> optionalJogador = jogadorRepo.findById(jogadorId);
        if (optionalJogador.isPresent()) {
            if (jogadorReq.getId() == jogadorId) {
                jogadorRepo.save(jogadorReq);
                return optionalJogador;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do jogador com id " + jogadorId);
    }

    @DeleteMapping("/api/jogadores/{id}")
    void deleteJogador(@PathVariable long id) {
        jogadorRepo.deleteById(id);
    }
}
