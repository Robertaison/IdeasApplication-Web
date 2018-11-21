//package br.com.thoughts.thoughts.mapper;
//
//import br.com.thoughts.thoughts.domain.Thought;
//import br.com.thoughts.thoughts.response.ThoughtResponse;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//@Mapper
//public interface ThoughtMapper {
//
//
//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "date", ignore = true)
//    })
//    Thought requestToThought(Thought thought);
//
//
//    @Mappings({
//            @Mapping(target = "date", dateFormat = "dd/MM/yyyy")
//    })
//    ThoughtResponse thoughtToResponse(Thought thought);
//}
