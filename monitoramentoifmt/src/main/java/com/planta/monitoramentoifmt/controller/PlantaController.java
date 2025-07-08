package com.planta.monitoramentoifmt.controller;

import com.planta.monitoramentoifmt.model.Localizacao;
import com.planta.monitoramentoifmt.model.Planta;
import com.planta.monitoramentoifmt.model.SaudePlanta;
import com.planta.monitoramentoifmt.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Anotação fundamental: diz que esta classe é um controlador web
public class PlantaController {

    // Injeção de Dependência: Pede ao Spring para nos dar uma instância do nosso repository
    @Autowired
    private PlantaRepository plantaRepository;

    /**
     * Este método será chamado quando o usuário acessar a URL "/plantas".
     * Ele busca todas as plantas no banco e as envia para a página de listagem.
     */
    @GetMapping("/plantas")
    public String listarPlantas(Model model) {
        // 1. Busca todos os registros de plantas no banco de dados
        java.util.List<Planta> listaDePlantas = plantaRepository.findAll();

        // 2. "Empacota" a lista para ser enviada para a página HTML
        // O nome "listaPlantas" será usado no HTML para acessar os dados
        model.addAttribute("listaPlantas", listaDePlantas);

        // 3. Retorna o nome do arquivo HTML que deve ser exibido
        return "listagem-plantas";
    }

    /**
     * Este método será chamado quando o usuário acessar a URL "/plantas/nova".
     * Ele apenas exibe o formulário de cadastro.
     */
    @GetMapping("/plantas/nova")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("planta", new Planta());
        // Adiciona as listas de opções para os selects do formulário
        model.addAttribute("opcoesLocalizacao", Localizacao.values());
        model.addAttribute("opcoesSaude", SaudePlanta.values());
        return "formulario-planta";
    }

    /**
     * Este método será chamado quando o formulário for enviado (via POST para "/plantas/salvar").
     * Ele recebe o objeto Planta preenchido e o salva no banco.
     */
    @PostMapping("/plantas/salvar")
    public String salvarPlanta(Planta planta) {
        // Usa o método save() do nosso repository para persistir a planta no banco
        plantaRepository.save(planta);

        // Redireciona o usuário de volta para a página de listagem
        return "redirect:/plantas";
    }
    
    /**
     * Método para DELETAR uma planta pelo ID.
     * Será chamado quando o usuário clicar no link "Excluir".
     * A anotação @PathVariable pega o 'id' que vem na URL.
     */
    @GetMapping("/plantas/excluir/{id}")
    public String excluirPlanta(@PathVariable("id") Long id) {
        plantaRepository.deleteById(id);
        return "redirect:/plantas"; // Redireciona de volta para a lista
    }

    /**
     * Método para carregar o formulário com os dados de uma planta para EDIÇÃO.
     * Será chamado quando o usuário clicar no link "Editar".
     */
    @GetMapping("/plantas/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable("id") Long id, Model model) {
        // Busca a planta no banco de dados pelo ID
        Planta planta = plantaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Planta inválido:" + id));

        // Envia a planta encontrada para o formulário
        model.addAttribute("planta", planta);
        // Envia as opções dos enums também
        model.addAttribute("opcoesLocalizacao", Localizacao.values());
        model.addAttribute("opcoesSaude", SaudePlanta.values());
        
        return "formulario-planta"; // Reutiliza o mesmo formulário de cadastro
    }
}