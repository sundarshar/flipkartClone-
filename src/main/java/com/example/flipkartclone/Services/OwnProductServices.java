package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Exception.CategoryNotFoundException;
import com.example.flipkartclone.Exception.ProductNotFoundException;
import com.example.flipkartclone.Model.Category;
import com.example.flipkartclone.Model.Product;
import com.example.flipkartclone.Repository.CategoryRepository;
import com.example.flipkartclone.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProducts")
public class OwnProductServices implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public OwnProductServices(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Product product = productRepository.findByIdIs(id);
        if(product == null){
            throw new ProductNotFoundException("ID number with "+ id +" is not valid. Try again with different ID");
        }
        return product;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product create = productDto.toProduct();
        Category category = null;
        if(productDto.getCategory()!=null){
            category = categoryRepository.findByName(productDto.getCategory());
        }
        if(category == null) {
            category = new Category();
            category.setName(productDto.getCategory());
        }
        categoryRepository.save(category);
        create.setCategory(category);
        productRepository.save(create);
        return create;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException {
        Product product = getSingleProduct(id);

        if(productDto.getTitle() != null){
            product.setName(productDto.getTitle());
        }

        if(productDto.getDescription() != null){
            product.setDescription(productDto.getDescription());
        }

        if(productDto.getImage() != null){
            product.setImage(productDto.getImage());
        }

        if(productDto.getPrice() != 0){
            product.setPrice(productDto.getPrice());
        }

        if(productDto.getCategory() != null){
            Category category = categoryRepository.findByName(productDto.getCategory());
            if(category == null){
                category = new Category();
                category.setName(productDto.getCategory());
                categoryRepository.save(category);
            }
            product.setCategory(category);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Product product = productRepository.findByIdIs(id);
        if(product==null){
            throw new ProductNotFoundException("Product with id "+ id+" is not exist. Try again with some other product");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsBasedOnCategory(String category) throws CategoryNotFoundException {
        List<Product> product = productRepository.findAllByCategoryNameIs(category);
        if(product == null){
            throw new CategoryNotFoundException("Category with name "+ category+" is not valid name");
        }
        return product;
    }


}
