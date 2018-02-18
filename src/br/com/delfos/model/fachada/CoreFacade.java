/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delfos.model.fachada;

import br.com.delfos.model.bo.AdministradorBo;
import br.com.delfos.model.bo.AlunoBo;
import br.com.delfos.model.bo.AulaBo;
import br.com.delfos.model.bo.EstadoBo;
import br.com.delfos.model.bo.interfaces.IAdministradorBo;
import br.com.delfos.model.bo.interfaces.IAlunoBo;
import br.com.delfos.model.bo.interfaces.IAulaBo;
import br.com.delfos.model.bo.interfaces.IEstadoBo;
import br.com.delfos.model.vo.AdministradorVo;
import br.com.delfos.model.vo.AlunoVo;
import br.com.delfos.model.vo.AulaVo;
import br.com.delfos.model.vo.EstadoVo;
import br.com.delfos.model.vo.UsuarioVo;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafaelgentil
 */
public class CoreFacade implements ICoreFacade {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("DelfosModelPU");
    IAdministradorBo AdmBO;
    IEstadoBo estadoBo;
    IAlunoBo alunoBo;
    IAulaBo aulaBo;

    public CoreFacade() {
        AdmBO = new AdministradorBo();
        estadoBo = new EstadoBo();
        alunoBo = new AlunoBo();
        aulaBo = new AulaBo();
    }

    @Override
    public AdministradorVo admEncontrarId(Long id) {
        return AdmBO.encontrarId(id, factory);
    }

    @Override
    public void admSalvarOuEditar(AdministradorVo adm) {
        AdmBO.salvarOuEditar(adm, factory);
    }

    @Override
    public UsuarioVo admEncontrarUsuario(UsuarioVo usuario) {
        return AdmBO.encontrarUsuario(factory, usuario);
    }

    /**
     * 
     * 
     */
    
    @Override
    public EstadoVo estEncontrarPorUf(String uf) {
        return estadoBo.encontrarPorUf(uf, factory);
    }

    @Override
    public List<EstadoVo> estBuscarPorNome(String descricao) {
        return estadoBo.buscarPorNome(descricao, factory);
    }

    @Override
    public EstadoVo estEncontrarPorId(Long id) {
        return estadoBo.encontrarPorId(id, factory);
    }

    @Override
    public void estSalvarOuEditar(EstadoVo estadoVo) {
        estadoBo.salvarOuEditar(estadoVo, factory);
    }

    @Override
    public EstadoVo estGetMunicipios(EstadoVo estadoVo) {
        return estadoBo.getMunicipios(estadoVo, factory);
    }
    /**
     * 
     * 
     * 
     */

    @Override
    public AlunoVo alunoEncontrarId(Long id) {
        return alunoBo.encontrarId(id, factory);
    }

    @Override
    public void alunoSalvarOuEditar(AlunoVo alunoVo) {
        alunoBo.salvarOuEditar(alunoVo, factory);
    }

    @Override
    public List<AlunoVo> alunoBuscarPorNome(String nome) {
        return alunoBo.buscarPorNome(factory, nome);
    }

    @Override
    public AlunoVo alunoGetTelefones(AlunoVo alunoVo) {
        return alunoBo.getTelefones(alunoVo, factory);
    }

    @Override
    public AlunoVo alunoGetVinculosAlunoCurso(AlunoVo alunoVo) {
        return alunoBo.getVinculosAlunoCurso(alunoVo, factory);
    }

    @Override
    public AlunoVo alunoBuscarPorCpf(String cpf) {
        return alunoBo.buscarPorCpf(factory, cpf);
    }
    /**
     * 
     * 
     *
     */

    @Override
    public AulaVo aulaEncontrarId(Long id, EntityManagerFactory factory) {
        return aulaBo.encontrarId(id, factory);
    }

    @Override
    public void aulaSalvarOuEditar(AulaVo aulaVo, EntityManagerFactory factory) {
        aulaBo.salvarOuEditar(aulaVo, factory);
    }

    @Override
    public List<AulaVo> aulaBuscarPorDescricao(EntityManagerFactory factory, String descricao) {
        return aulaBo.buscarPorDescricao(factory, descricao);
    }

    @Override
    public List<AulaVo> aulaBuscarPorData(EntityManagerFactory factory, Calendar data) {
        return aulaBo.buscarPorData(factory, data);
    }
    


}
