package com.portfolio.cv.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "image")
    private java.sql.Blob image;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
