package fr.cours.isima.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Article")
@Table(name = "ARTICLE")
public class ArticleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "reference", unique = true)
    @Size(min = 3, max = 10)
    private String reference;

    @Column(name = "description")
    @Size(max = 250, message = "La description doit faire moins de 250 caracteres")
    private String description;

    @JoinColumn(name = "category", nullable = false, referencedColumnName = "id")
    @OneToOne(targetEntity = CategorieBean.class)
    @NotNull(message = "Catégorie obligatoire")
    private CategorieBean category;

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(CategorieBean category) {
        this.category = category;
    }

    public CategorieBean getCategory() {
        return category;
    }
}
