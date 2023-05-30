create database ban_laptop;
    
use ban_laptop;


create table if not exists Admin
(
    username text not null,
    password text not null
);

insert into Admin
values ('admin', 'admin');

# drop table User;
create table if not exists User
(
    id           int primary key auto_increment,
    email        text    not null,
    name         text    not null,
    password     text    not null,
    phone_number text    not null,
    address      text    not null,
    active       boolean not null default true
);


# drop table ProductCategory;
create table if not exists ProductCategory
(
    id          int primary key auto_increment,
    name        text    not null,
    active      boolean not null default true
);

# drop table Color;
create table if not exists Color
(
    id     int primary key auto_increment,
    color  text,
    active boolean not null default true
);

# drop table Size;
create table if not exists Size
(
    id     int primary key auto_increment,
    size   text,
    active boolean not null default true
);

# drop table Product;
create table if not exists Product
(
    id            int primary key auto_increment,
    category_id   int,
    name          text    not null,
    description   text    not null,
    active        boolean not null default true,
    display_image text    not null,
    quantity      int     not null default 0 CHECK ( quantity >= 0 ),
    price         decimal not null default 0 check ( price >= 0 ),
    color_id      int     not null,
    size_id       int     not null,
    foreign key (category_id) references ProductCategory (id),
    foreign key (color_id) references Color (id),
    foreign key (size_id) references Size (id)
);





# drop table ShoppingSession;
create table if not exists ShoppingSession
(
    id      int primary key auto_increment,
    user_id int not null,
    foreign key (user_id) references User (id)
);

# drop table CartItem;
create table if not exists CartItem
(
    id         int not null auto_increment primary key,
    product_id int not null,
    session_id int not null,
    user_id    int not null,
    quantity   int not null,
    size_id    int not null,
    color_id   int not null,
    foreign key (product_id) references Product (id),
    foreign key (session_id) references ShoppingSession (id),
    foreign key (session_id) references ShoppingSession (id),
    foreign key (size_id) references Size (id),
    foreign key (color_id) references Color (id)
);

# drop table OrderDetail
create table if not exists OrderDetail
(
    id      int not null auto_increment primary key,
    user_id int not null,
    note    text
);

# drop table OrderItem;
create table if not exists OrderItem
(
    id         int primary key auto_increment,
    quantity   int not null check ( quantity >= 0 ),
    product_id int not null,
    size_id    int not null,
    color_id   int not null,
    order_id   int not null,
    foreign key (product_id) references Product (id),
    foreign key (size_id) references Size (id),
    foreign key (color_id) references Color (id),
    foreign key (order_id) references OrderDetail (id)
);

# drop table PaymentDetail;
create table if not exists PaymentDetail
(
    id              int auto_increment primary key,
    order_id        int  not null,
    user_id         int  not null,
    amount          int  not null check ( amount >= 0),
    delivery_status text not null,
    address         text not null,
    phone_number    text not null,
    note            text,
    foreign key (order_id) references OrderDetail (id),
    foreign key (user_id) references User (id)
);

# drop table Comment;
create table if not exists Comment
(
    id         int auto_increment primary key not null,
    user_id    int                            not null,
    product_id int                            not null,
    content    text                           not null,
    foreign key (user_id) references User (id),
    foreign key (product_id) references Product (id)
)