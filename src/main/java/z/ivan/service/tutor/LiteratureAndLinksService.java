package z.ivan.service.tutor;

import org.springframework.stereotype.Service;
import z.ivan.dao.LinkDao;
import z.ivan.dao.LiteratureDao;
import z.ivan.dto.LinkEditDto;
import z.ivan.dto.LiteratureEditDto;
import z.ivan.model.Link;
import z.ivan.model.Literature;

import java.util.List;

@Service
public class LiteratureAndLinksService {

    private LinkDao linkDao;
    private LiteratureDao literatureDao;

    public LiteratureAndLinksService(LinkDao linkDao, LiteratureDao literatureDao) {
        this.linkDao = linkDao;
        this.literatureDao = literatureDao;
    }

    public void edit(List<LiteratureEditDto> questionList) {
        for (LiteratureEditDto e : questionList) {
            Long id = e.getId();
            switch (e.getAction()) {
                case "create":
                    id = literatureDao.add(e.getLiterature());
                    break;
                case "delete":
                    literatureDao.delete(e.getLiterature().getQuestionId());
                    id = 0L;
                    break;
                case "rename":
                    literatureDao.update(e.getLiterature());
                    break;
                case "skip":
                    break;
            }
            if (!id.equals(0L)) {
                for (LinkEditDto ae : e.getLinks()) {
                    Link answer = ae.getLink();
                    answer.setLiteratureId(id);
                    switch (ae.getAction()) {
                        case "create":
                            linkDao.add(answer);
                            break;
                        case "delete":
                            linkDao.delete(answer.getLinkId());
                            break;
                        case "rename":
                            linkDao.update(answer);
                            break;
                        case "skip":
                            break;
                    }
                }
            }
        }
    }

    public List<Link> getLinkList() {
        return linkDao.getAll();
    }

    public List<Literature> getLiteratureList() {
        return literatureDao.getAll();
    }
}
