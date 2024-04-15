package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryParentResponse;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @Operation(summary = "Create a new category", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = CategoryRequest.class), examples = @ExampleObject(value = """
            {
                "name": "Category 1",
                "icons": "icon",
                "alias": "category-1",
                "parentCategoryId": 0
            }
            """))))
    public BaseResponse<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return BaseResponse.<CategoryResponse>createSuccess().setPayload(categoryService.createCategory(categoryRequest));
    }

    @GetMapping
    @Operation(summary = "Get list of categories")
    Page<CategoryResponse> findList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "2") int limit) {
        return BaseResponse.<Page<CategoryResponse>>ok().setPayload(categoryService.getCategories(page, limit)).getPayload();
    }

    @GetMapping("/parents")
    @Operation(summary = "Get list of parent categories")
    public BaseResponse<List<CategoryParentResponse>> getParentCategories() {
        return BaseResponse.<List<CategoryParentResponse>>ok().setPayload(categoryService.getParentCategories());
    }

    @GetMapping("/{alias}")
    @Operation(summary = "Get category by alias")
    public BaseResponse<CategoryResponse> getCategoryByAlias(@PathVariable String alias) {
        return BaseResponse.<CategoryResponse>ok().setPayload(categoryService.getCategoryByAlias(alias));
    }

    @PutMapping("/{alias}")
    @Operation(summary = " Update a category’s information", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = CategoryRequest.class), examples = @ExampleObject(value = """
            {
                "name": "Category 1",
                "icons": "icon",
                "alias": "category-1",
                "parentCategoryId": 0
            }
            """))))
    public BaseResponse<CategoryResponse> updateCategoryByAlias(@PathVariable String alias, @Valid @RequestBody CategoryRequest categoryRequest) {
        return BaseResponse.<CategoryResponse>updateSuccess().setPayload(categoryService.updateCategoryByAlias(alias, categoryRequest));
    }

    @PutMapping("/{alias}/disable")
    @Operation(summary = "Disable a category")
    public BaseResponse<CategoryResponse> disableCategoryByAlias(@PathVariable String alias) {
        return BaseResponse.<CategoryResponse>disableSuccess().setPayload(categoryService.disableCategoryByAlias(alias));
    }

}
