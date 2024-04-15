package co.istad.jbsdemo.spring_elearning_api.feature.category;

import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryRequest;
import co.istad.jbsdemo.spring_elearning_api.feature.category.dto.CategoryResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @Operation(summary = "Create a new category", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = CategoryRequest.class), examples = @ExampleObject(value = """
            {
                "name": "Category Name",
                "alias": "category-name",
                "description": "Category Description",
                "parentCategoryId": 1
            }
            """))))
    public BaseResponse<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return BaseResponse.<CategoryResponse>createSuccess().setPayload(categoryService.createCategory(categoryRequest));
    }
}
