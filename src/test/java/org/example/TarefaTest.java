package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    private Tarefa tarefa;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa();
        tarefa.setDescricao("Tarefa de Exemplo");
    }

    // Testes para estado Pendente

    @Test
    public void deveIniciarTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertTrue(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveConcluirTarefaPendente() {
        tarefa.setEstado(TarefaEstadoPendente.getInstance());
        assertFalse(tarefa.concluir());
        assertEquals(TarefaEstadoPendente.getInstance(), tarefa.getEstado());
    }

    // Testes para estado Em Progresso

    @Test
    public void deveConcluirTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.concluir());
        assertEquals(TarefaEstadoConcluida.getInstance(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertTrue(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveIniciarTarefaEmProgresso() {
        tarefa.setEstado(TarefaEstadoEmProgresso.getInstance());
        assertFalse(tarefa.iniciar());
        assertEquals(TarefaEstadoEmProgresso.getInstance(), tarefa.getEstado());
    }

    // Testes para estado Concluída

    @Test
    public void naoDeveIniciarTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.iniciar());
        assertEquals(TarefaEstadoConcluida.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveConcluirTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.concluir());
        assertEquals(TarefaEstadoConcluida.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveCancelarTarefaConcluida() {
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());
        assertFalse(tarefa.cancelar());
        assertEquals(TarefaEstadoConcluida.getInstance(), tarefa.getEstado());
    }

    // Testes para estado Cancelada

    @Test
    public void naoDeveIniciarTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.iniciar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveConcluirTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.concluir());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDeveCancelarTarefaCancelada() {
        tarefa.setEstado(TarefaEstadoCancelada.getInstance());
        assertFalse(tarefa.cancelar());
        assertEquals(TarefaEstadoCancelada.getInstance(), tarefa.getEstado());
    }
}
