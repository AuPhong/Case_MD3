package model;

public class Category {
        private int categoryId;
        private String cateName;

    public Category() {
    }

    public Category(int categoryId, String cateName) {
        this.categoryId = categoryId;
        this.cateName = cateName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}
