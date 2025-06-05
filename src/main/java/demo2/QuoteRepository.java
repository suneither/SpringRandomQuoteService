package demo2;

import org.springframework.data.jpa.repository.JpaRepository;

interface QuoteRepository extends JpaRepository<Quote, Long> {
}
