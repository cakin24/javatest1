package toolutils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysRole implements Serializable  {


    private String id;
    
    private String name;


    private List<SysResource> resources;

    private static final long serialVersionUID = 1L;

}
