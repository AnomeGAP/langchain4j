package dev.langchain4j.model.ollama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
class ToolCall {

    private Optional<String> id;

    private FunctionCall function;

    ToolCall() {
    }

    ToolCall(FunctionCall function) {
        this.id = Optional.empty();
        this.function = function;
    }

    ToolCall(Optional<String> id, FunctionCall function) {
        this.id = id;
        this.function = function;
    }

    static Builder builder() {
        return new Builder();
    }

    public Optional<String> getId() { return id; }

    public FunctionCall getFunction() {
        return function;
    }

    public void setId(String id) {
        this.id = Optional.of(id);
    }

    public void setFunction(FunctionCall function) {
        this.function = function;
    }

    static class Builder {

        private Optional<String> id = Optional.empty();

        private FunctionCall function;

        Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        Builder function(FunctionCall function) {
            this.function = function;
            return this;
        }

        ToolCall build() {
            return new ToolCall(id, function);
        }
    }
}
