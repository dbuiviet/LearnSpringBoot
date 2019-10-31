package com.dbuiviet.spring.learnSpringBoot.model;

import java.util.Date;

public class ToDo {
    private int id;
    private String user;
    private String desc;
    private Date deadline;
    private boolean finished;

    public ToDo(int id, String user, String desc, Date deadline, boolean finished) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.deadline = deadline;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (prime + id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        ToDo other = (ToDo) obj;
        if (id != other.id){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Tdo [id=%s, user=%s, desc=%s, deadline=%s, finished=%s]",
                id, user, desc, deadline, finished);
    }
}
