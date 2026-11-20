package br.com.sistema;

import br.com.sistema.controller.CadastroController;
import br.com.sistema.model.UsuarioModel;
import br.com.sistema.view.CadastroView;

import javax.swing.SwingUtilities;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UsuarioModel model = new UsuarioModel();
                CadastroView view = new CadastroView();

                // Popula a JTable com os dados salvos no MySQL
                List<String> usuariosSalvos = model.getUsuarios();
                for (int i = 0; i < usuariosSalvos.size(); i++) {
                    view.adicionarLinhaTabela(i + 1, usuariosSalvos.get(i));
                }

                new CadastroController(model, view);
                view.setVisible(true);
            }
        });
    }
}