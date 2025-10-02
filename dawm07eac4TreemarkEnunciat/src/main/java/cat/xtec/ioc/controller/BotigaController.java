package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Article;
import cat.xtec.ioc.service.ArticleService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Germán Flores
 */
@Controller
public class BotigaController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homeRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> info = new HashMap();
        info.put("title", "Afegir");
        info.put("desc", "Permet afegir un article al catàleg de la botiga.");
        info.put("url", "/add");
        info.put("icon", "glyphicon-plus-sign glyphicon");
        data.add(info);
        Map<String, String> info2 = new HashMap();
        info2.put("title", "Consultar");
        info2.put("desc", "Permet consultar la informació d'un article de la botiga.");
        info2.put("url", "/get");
        info2.put("icon", "glyphicon-search glyphicon");
        data.add(info2);
        Map<String, String> info3 = new HashMap();
        info3.put("title", "Comprar");
        info3.put("desc", "Permet comprar algun article de la botiga.");
        info3.put("url", "/venda");
        info3.put("icon", "glyphicon-shopping-cart glyphicon");
        data.add(info3);
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        modelview.getModelMap().addAttribute("options", data);
        return modelview;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addArticleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("home");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        modelview.getModelMap().addAttribute("tagline", "Afegir un article al catàleg");
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> info = new HashMap();
        info.put("title", "Article");
        info.put("desc", "Permet afegir un article al catàleg de la botiga.");
        info.put("url", "/add/Article");
        info.put("icon", "glyphicon-tree-conifer glyphicon");
        data.add(info);
        modelview.getModelMap().addAttribute("options", data);
        return modelview;
    }

    @RequestMapping(value = "/add/{tipus}", method = RequestMethod.GET)
    public ModelAndView addArticleForm(@PathVariable("tipus") String tipusArticle, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ModelAndView modelview = new ModelAndView("add" + tipusArticle);
        modelview.getModelMap().addAttribute("tagline", "Afegir un article al catàleg");
        modelview.getModelMap().addAttribute("newArticle",
                Class.forName("cat.xtec.ioc.domain." + tipusArticle).newInstance());
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        return modelview;
    }
    
    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("numeroVendes");
    }
    
    @RequestMapping(value = "/add/{tipus}", method = RequestMethod.POST)
    public String addArticleForm(@PathVariable("tipus") String tipusArticle, @ModelAttribute("newArticle") Article newArticleToAdd, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        articleService.addArticle(newArticleToAdd);
        return "redirect:/";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getArticleFormRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("getArticleForm");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        return modelview;
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ModelAndView getArticleByCodiRequest(@RequestParam  String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("infoArticle");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un Article.");
        modelview.getModelMap().addAttribute("article", articleService.getArticleByCodi(codi));
        return modelview;
    }
    
    @RequestMapping("/venda")
    public ModelAndView getVenda( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("helpVendes");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        modelview.getModelMap().addAttribute("tagline", "Ajuda per la venda d'un article.");
        return modelview;
    }
    
    @RequestMapping(value = "/getArticle/{codi}", method = RequestMethod.GET)
    public ModelAndView getArticleByCodiVendaRequest(@PathVariable  String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ModelAndView modelview = new ModelAndView("infoArticle");
        modelview.getModelMap().addAttribute("banner", "Articles de Nadal!");
        modelview.getModelMap().addAttribute("tagline", "Dades d'un article.");
        modelview.getModelMap().addAttribute("article", articleService.getArticleByCodi(codi));
        return modelview;
    }

}
