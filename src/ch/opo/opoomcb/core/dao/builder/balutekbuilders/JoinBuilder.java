package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.Join;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class JoinBuilder extends AbstractBuilder<Join>
{
   protected JoinBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      super(previousBuilders);
   }


}
