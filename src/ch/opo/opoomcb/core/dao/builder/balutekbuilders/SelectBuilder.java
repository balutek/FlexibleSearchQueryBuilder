package ch.opo.opoomcb.core.dao.builder.balutekbuilders;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.From;
import ch.opo.opoomcb.core.dao.builder.model.Select;
import ch.opo.opoomcb.core.dao.builder.model.Table;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class SelectBuilder extends AbstractBuilder<Select>
{
   private static final String PK = "pk";

   private FromBuilder fromBuilder;

   public SelectBuilder(LinkedList<AbstractBuilder> previousBuilders)
   {
      super(previousBuilders);
   }

   public SelectBuilder pk()
   {
      constructedObject.addColumn(new Column(PK));
      return this;
   }

   public SelectBuilder pk(String alias)
   {
      constructedObject.addColumn(new Column(PK, alias));
      return this;
   }

   public SelectBuilder column(String name)
   {
      constructedObject.addColumn(new Column(name));
      return this;
   }

   public SelectBuilder column(String alias, String name)
   {
      constructedObject.addColumn(new Column(name, alias));
      return this;
   }

   public FromBuilder from(String typecode)
   {
      From from = new From(new Table(typecode));
      constructedObject.addFrom(from);
      previousBuilders.add(this);
      fromBuilder.setConstructedObject(from);
      return fromBuilder;
   }

   public FromBuilder from(String alias, String typecode)
   {
      From from = new From(new Table(typecode, alias));
      constructedObject.addFrom(from);
      previousBuilders.add(this);
      fromBuilder = new FromBuilder(previousBuilders);
      fromBuilder.setConstructedObject(from);
      return fromBuilder;
   }

}
