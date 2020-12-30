package com.altimetrik.rulesmanager.drool.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.altimetrik.rulesmanager.drool.model.Kbase;
import com.altimetrik.rulesmanager.drool.model.Kmodule;
import com.altimetrik.rulesmanager.drool.model.Ksession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@Service
public class KmoduleServiceImpl implements KmoduleService {

  @Value("${kmodule.file.classPath}")
  private String kmoduleFile;
  
  @Value("${kmodule.file.completePath}")
  private String kmoduleFileCompletePath;

  @Autowired
  private XmlMapper xmlMapper;

  @Override
  public boolean createOrUpdate(Kbase kbase) throws Exception {

    boolean isFileUpdated = false;
    Kmodule newKmodule = new Kmodule();
    newKmodule.setXmlns("http://www.drools.org/xsd/kmodule");
    try (InputStream inputStream =
        this.getClass().getClassLoader().getResourceAsStream(kmoduleFile)) {
      Kmodule kmodule = xmlMapper.readValue(inputStream, Kmodule.class);
      List<Kbase> kbases = kmodule.getKbase();
      Optional<Kbase> kbasePresent =
          kbases.stream().filter(k -> k.getPackages().equals(kbase.getPackages())).findAny();

      if (kbasePresent.isPresent()) {
        if (!kbasePresent.get().equals(kbase)) {
          // Kbase updated //TODO override kbase for equality
          newKmodule.setKbase(kbases);
          isFileUpdated = updateKmodule(newKmodule);
          kbases.remove(kbasePresent.get());
          kbases.add(kbase);
        }
      } else {
        kbases.add(kbase);
        newKmodule.setKbase(kbases);
        isFileUpdated = updateKmodule(newKmodule);
      }

    } catch (Exception ex) {
      System.out.println("Error occured " + ex);
      throw ex;
    }
    return isFileUpdated;
  }

  private boolean updateKmodule(Kmodule newKmodule) {
    try {
      Path path = Paths.get(kmoduleFileCompletePath);
      File newFile = new File(path.getParent().toAbsolutePath().toFile(), "kmodule_NEW.xml");
      System.out.println(newFile);
      xmlMapper.writeValue(newFile, newKmodule);
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main(String[] a) throws Exception {


    String path = "META-INF/kmodule.xml";
    ClassLoader classLoader = new KmoduleServiceImpl().getClass().getClassLoader();
    InputStream inputStream0 = classLoader.getResourceAsStream(path);
    Scanner sc = new Scanner(inputStream0);
    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
    }
    /*
     * buildxml(); InputStream inputStream = classLoader.getResourceAsStream(path); XmlMapper mapper
     * = new XmlMapper(); mapper.registerModule(new JaxbAnnotationModule()); Kmodule kmodule =
     * mapper.readValue(inputStream, Kmodule.class);
     * System.out.println(kmodule.getKbase().get(0).getPackages());
     */
    Path p = Paths.get(path);
    System.out.println(p.toUri());
    File f = new File(classLoader.getResource(".").getFile() + "/test.xml");
    if(f.createNewFile()) {
      System.out.println(true);
    }else {
      System.out.println(false);
    }
  }

  private static void buildxml() throws JsonProcessingException {
    System.out.println("====================================");
    Kbase kbase1 = new Kbase();
    kbase1.setPackages("com.altimetrik.rulesmanager.drool.default");
    Ksession ksession1 = new Ksession();
    ksession1.setName("default");
    ksession1.setType("stateless");

    List<Kbase> arr = new ArrayList<Kbase>();
    arr.add(kbase1);
    Kmodule mod = new Kmodule();
    mod.setXmlns("http://www.drools.org/xsd/kmodule");
    mod.setKbase(arr);

    XmlMapper mapper = new XmlMapper();
    mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    System.out.println(mapper.writeValueAsString(mod));

  }

}
