package com.agenda.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.agenda.model.Contato;
import com.agenda.model.Endereco;
import com.agenda.model.Pessoa;
import com.agenda.service.CadastraUsuarioService;

@WebServlet("/cadastra-usuario")
public class CadastraUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CadastraUsuarioService service;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Map<String, String> parameters = uploadFoto(request);

		Pessoa pessoa = new Pessoa();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		if (null != parameters.get("id") && !"".equals(parameters.get("id"))) {
			pessoa.setId(Long.parseLong(parameters.get("id")));
		}
		
		pessoa.setFoto(parameters.get("foto"));
		pessoa.setNome(parameters.get("nome"));
		pessoa.setDataNascimento(parameters.get("dataNascimento"));

		if (null != parameters.get("id_endereco") && !"".equals(parameters.get("id_endereco"))) {
			endereco.setId(Long.parseLong(parameters.get("id_endereco")));
		}
		endereco.setLogradouro(parameters.get("logradouro"));
		endereco.setCep(parameters.get("cep"));

		if (null != parameters.get("id_contato") && !"".equals(parameters.get("id_contato"))) {
			contato.setId(Long.parseLong(parameters.get("id_contato")));
		}
		contato.setEmail(parameters.get("email"));
		contato.setTelefone(parameters.get("telefone"));

		pessoa.setContato(contato);
		pessoa.setEndereco(endereco);

		this.service = new CadastraUsuarioService();

		PrintWriter out = response.getWriter();

		try {

			this.service.salvarOuAtualizar(pessoa);

			response.sendRedirect("busca-contatos");

		} catch (Exception e) {
			out.println("<html>");
			out.println("<body>");
			out.println("Falha ao realizar o cadastro!");
			out.println("</body>");
			out.println("</html>");
		}

	}

	private Map<String,String> uploadFoto(HttpServletRequest request) {

		Map<String,String> parameters = new HashMap<String,String>();
		
		if (ServletFileUpload.isMultipartContent(request)) {

			try {

				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String fileName = processUploadedFile(item);
						parameters.put("foto", "img/".concat(fileName));
					} else {
						parameters.put(item.getFieldName(), item.getString());
					}
				}

			} catch (Exception ex) {
				parameters.put("foto", "img/default-avatar.jpg");
			}

		} else {
			parameters.put("foto", "img/default-avatar.jpg");
		}
		return parameters;
	}

	private String processUploadedFile(FileItem item) throws Exception {
		Long time = new Date().getTime();
		String fileName = time.toString().concat("-").concat(item.getName());
		String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
		item.write(new File(filePath));
		return fileName;
	}

}
