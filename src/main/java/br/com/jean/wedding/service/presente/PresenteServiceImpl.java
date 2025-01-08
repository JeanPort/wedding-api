package br.com.jean.wedding.service.presente;

import br.com.jean.wedding.dto.PresenteDTO;
import br.com.jean.wedding.model.Presente;
import br.com.jean.wedding.repo.PresenteRepo;
import org.springframework.stereotype.Service;

@Service
public class PresenteServiceImpl implements IPresenteService{

    private final PresenteRepo repo;

    public PresenteServiceImpl(PresenteRepo repo) {
        this.repo = repo;
    }

    @Override
    public PresenteDTO save(PresenteDTO novo) {
        Presente presente = fromEntity(novo);
        return fromDto(repo.save(presente));
    }

    private Presente fromEntity(PresenteDTO dto){
        Presente presente = new Presente();
        presente.setDescricao(dto.descricao());
        presente.setId(dto.id());
        presente.setNome(dto.nome());
        presente.setPreco(dto.preco());
        presente.setLinkFoto(dto.linkFoto());
        return presente;
    }

    private PresenteDTO fromDto(Presente presente) {
        return new PresenteDTO(presente.getId(), presente.getNome(), presente.getDescricao(), presente.getLinkFoto(), presente.getPreco());
    }
}
