package org.hfu.kkm.core;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BasicEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/
    @Version
    private int version;

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
