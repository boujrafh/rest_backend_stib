package hello.dao;

import hello.model.Calendar;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class CalendarRepository extends RepositoryImpl<Calendar> {}