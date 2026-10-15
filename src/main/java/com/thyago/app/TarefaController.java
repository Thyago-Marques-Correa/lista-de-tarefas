package com.thyago.app;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TarefaController {

    public static class Tarefa {
        private final long id;
        private final String texto;
        private boolean feita;

        public Tarefa(long id, String texto) {
            this.id = id;
            this.texto = texto;
        }

        public long getId() { return id; }
        public String getTexto() { return texto; }
        public boolean isFeita() { return feita; }
        public void alternar() { this.feita = !this.feita; }
    }

    private final List<Tarefa> tarefas = new CopyOnWriteArrayList<>();
    private final AtomicLong sequencia = new AtomicLong();

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("tarefas", tarefas);
        return "index";
    }

    @PostMapping("/add")
    public String adicionar(@RequestParam String texto) {
        if (!texto.isBlank()) {
            tarefas.add(new Tarefa(sequencia.incrementAndGet(), texto.trim()));
        }
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String alternar(@PathVariable long id) {
        tarefas.stream().filter(t -> t.getId() == id).findFirst().ifPresent(Tarefa::alternar);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String remover(@PathVariable long id) {
        tarefas.removeIf(t -> t.getId() == id);
        return "redirect:/";
    }
}
