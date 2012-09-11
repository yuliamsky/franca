/*
 * generated by Xtext
 */
package org.franca.deploymodel.dsl.ui.labeling;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.franca.core.franca.FType;
import org.franca.deploymodel.core.GenericPropertyAccessor;
import org.franca.deploymodel.dsl.FDModelHelper;
import org.franca.deploymodel.dsl.fDeploy.FDArgument;
import org.franca.deploymodel.dsl.fDeploy.FDArray;
import org.franca.deploymodel.dsl.fDeploy.FDAttribute;
import org.franca.deploymodel.dsl.fDeploy.FDBoolean;
import org.franca.deploymodel.dsl.fDeploy.FDBroadcast;
import org.franca.deploymodel.dsl.fDeploy.FDDeclaration;
import org.franca.deploymodel.dsl.fDeploy.FDEnum;
import org.franca.deploymodel.dsl.fDeploy.FDEnumerator;
import org.franca.deploymodel.dsl.fDeploy.FDField;
import org.franca.deploymodel.dsl.fDeploy.FDInteger;
import org.franca.deploymodel.dsl.fDeploy.FDInterface;
import org.franca.deploymodel.dsl.fDeploy.FDInterfaceInstance;
import org.franca.deploymodel.dsl.fDeploy.FDMethod;
import org.franca.deploymodel.dsl.fDeploy.FDProperty;
import org.franca.deploymodel.dsl.fDeploy.FDPropertyDecl;
import org.franca.deploymodel.dsl.fDeploy.FDString;
import org.franca.deploymodel.dsl.fDeploy.FDStruct;
import org.franca.deploymodel.dsl.fDeploy.FDUnion;
import org.franca.deploymodel.dsl.fDeploy.Import;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class FDeployLabelProvider extends DefaultEObjectLabelProvider {

   private final String DEFAULT_PROPERTY_MARKER = "?";
   private final String DEFAULT_VALUE_MARKER = "?=";

   @Inject
   public FDeployLabelProvider(AdapterFactoryLabelProvider delegate) {
      super(delegate);
   }

   public String text(FDMethod element) {
      return element.getTarget().getName();
   }

   public String text(FDInterfaceInstance element) {
      return element.getTarget().getName();
   }

   public String text(FDInterface element) {
      return element.getTarget().getName();
   }

   public String text(FDAttribute element) {
      return element.getTarget().getName();
   }

   public String text(FDBroadcast element) {
      return element.getTarget().getName();
   }

   public String text(FDArgument element) {
      return element.getTarget().getName();
   }

   public String text(FDArray element) {
      return element.getTarget().getName();
   }

   public String text(FDField element) {
      return element.getTarget().getName();
   }

   public String text(FDStruct element) {
      return element.getTarget().getName();
   }

   public String text(FDUnion element) {
      return element.getTarget().getName();
   }

   public String text(FDProperty element) {
      return element.getDecl().getName();
   }

   public String text(FDInteger element) {
      return getDefaultMarker(element) + String.valueOf(element.getValue());
   }

   public String text(FDString element) {
      return getDefaultMarker(element) + element.getValue();
   }

   public String text(FDBoolean element) {
      return getDefaultMarker(element) + element.getValue();
   }

   public String text(FDEnum element) {
      return getDefaultMarker(element) + element.getValue().getName();
   }

   public String text(FDEnumerator element) {
      return getDefaultMarker(element) + element.getName();
   }

   public String text(FDDeclaration element) {
      String name = element.getHost().getLiteral();

      return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
   }

   public String text(FDPropertyDecl element) {
      String name = new String();

      if (!FDModelHelper.isMandatory(element)) {
         name += DEFAULT_PROPERTY_MARKER;
      }
      name += element.getName();
      return name;
   }

   public String getDefaultMarker(EObject element) {
      if (GenericPropertyAccessor.isSpecification(element)) {
         if (GenericPropertyAccessor.isDefault(element)) {
            return DEFAULT_VALUE_MARKER;
         }
      }
      return "";
   }

   public String image(FDInterface element) {
      return "interface.png";
   }

   public String image(FDAttribute element) {
      return "attribute.gif";
   }

   public String image(FDMethod element) {
      return "method.gif";
   }

   public String image(FDField element) {
      return "field.gif";
   }

   public String image(FDEnum element) {
      return "enum.gif";
   }

   public String image(FDEnumerator element) {
      return "enumerator.gif";
   }

   public String image(FType element) {
      return "types.gif";
   }

   public String image(FDStruct element) {
	      return "struct.gif";
	   }

   public String image(FDUnion element) {
	      return "struct.gif"; // TODO: different image for unions?
	   }

   public String image(Import element) {
      return "import.gif";
   }

   public String image(FDBroadcast element) {
      return "event.png";
   }

   public String image(FDArgument element) {
	  EObject parent = element.eContainer().eContainer(); 
      if (parent instanceof FDBroadcast
            || (parent instanceof FDMethod && ((FDMethod)parent).getOutArguments().getArguments().contains(element))) {
         return "overlay-out.gif";
      } else {
         return "overlay-in.gif";
      }
   }

   public String image(FDDeclaration element) {
      switch (element.getHost()) {
      case INTERFACES:
         return "interface.png";
      case ATTRIBUTES:
         return "attribute.gif";
      case METHODS:
         return "method.gif";
      case STRUCT_FIELDS:
          return "field.gif";
      case UNION_FIELDS:
          return "field.gif";
      case ENUMERATIONS:
         return "enum.gif";
      case ENUMERATORS:
         return "enumerator.gif";
      case BROADCASTS:
         return "event.png";
      case STRINGS:
         return "strings.png";
      case NUMBERS: // fall-through
      case INTEGERS: // fall-through
      case FLOATS:
         return "numbers.png";
      case ARRAYS:
         return "arrays.png";
      }
      return null;
   }
}
