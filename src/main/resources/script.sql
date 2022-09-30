select o.product_name
    from homework.customers c
         join homework.orders o on c.id = o.customer_id
    where c.name = :name;