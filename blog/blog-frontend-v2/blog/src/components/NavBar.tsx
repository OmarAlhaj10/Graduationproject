import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import {
  Navbar,
  NavbarBrand,
  NavbarContent,
  NavbarItem,
  NavbarMenu,
  NavbarMenuItem,
  NavbarMenuToggle,
  Button,
  Avatar,
  Dropdown,
  DropdownTrigger,
  DropdownMenu,
  DropdownItem,
} from '@nextui-org/react';
import "../assets/main.css"
import { Plus, BookOpen, Edit3, LogOut, User, BookDashed } from 'lucide-react';

interface NavBarProps {
  isAuthenticated: boolean;
  userProfile?: {
    name: string;
    avatar?: string;
  };
  onLogout: () => void;
}

const NavBar: React.FC<NavBarProps> = ({
  isAuthenticated,
  userProfile,
  onLogout,
}) => {
  const location = useLocation();
  const [isMenuOpen, setIsMenuOpen] = React.useState(false);

  const menuItems = [
    { name: 'Home', path: '/' },
    { name: 'Categories', path: '/categories' },
    { name: 'Tags', path: '/tags' },
  ];

  return (
    <Navbar
      isBordered
      isMenuOpen={isMenuOpen}
      onMenuOpenChange={setIsMenuOpen}
      className="mb-6 bckgroung_main"
      
    >
      <NavbarContent className="sm:hidden" justify="start">
        <NavbarMenuToggle />
      </NavbarContent>

      <NavbarContent className="sm:hidden pr-3" justify="center">
        <NavbarBrand>
          <Link to="/" className="font-bold text-inherit">Blog Platform</Link>
        </NavbarBrand>
      </NavbarContent>

      <NavbarContent className="hidden sm:flex gap-4" justify="start">
        <NavbarBrand>
          <Link to="/" className="anton-regular tracking-wider font-bold text-inherit text-2xl text-red-600">PurelyFit</Link>
        </NavbarBrand>
        {menuItems.map((item) => (
          <NavbarItem
            key={item.path}
            isActive={location.pathname === item.path}
          >
            <Link
              to={item.path}
              className={`text-sm ${
                location.pathname === item.path
                  ? 'text-red-600'
                  : 'text-white'
              }`}
            >
              {item.name}
            </Link>
          </NavbarItem>
        ))}
      </NavbarContent>

      <NavbarContent justify="end">
        {isAuthenticated ? (
          <>
            <NavbarItem className=''>
              <Button
                as={Link}
                to="/posts/drafts"
                className='ms-3 text-white bg-transparent hover:bg-transparent hover:text-red-600 hover:scale-125'
                variant="flat"
                startContent={<BookDashed  size={16} />}
              >
                Draft Posts
              </Button>
            </NavbarItem>
            <NavbarItem>
              <Button
                as={Link}
                to="/posts/new"
                className='text-white bg-transparent hover:bg-transparent hover:text-red-600 hover:scale-125'
                variant="flat"
                startContent={<Plus size={16} />}
              >
                New Post
              </Button>
            </NavbarItem>
            <NavbarItem>
              <Button
                                  className='text-white bg-transparent hover:bg-transparent hover:text-red-600 hover:scale-125'
                  variant="flat"
                  onClick={() => {
                    const nickname = 'zeit';
                    const realname = 'ZEIT Dev';
                    const url = `http://localhost:8181/?nickname=${encodeURIComponent(nickname)}&realname=${encodeURIComponent(realname)}`;
                    window.location.href = url;
                  }}
              >
                Diet Plan
              </Button>
            </NavbarItem>

            <NavbarItem>
              <form
                  id="autoLoginForm"
                  action="http://localhost/login"
                  method="POST"
                  style={{ display: 'none' }}
              >
                <input type="hidden" name="username" value="admin" />
                <input type="hidden" name="password" value="123" />
              </form>
              <Button
                                  className='text-white bg-transparent hover:bg-transparent hover:text-red-600 hover:scale-125'
                  variant="flat"
                  onClick={() => document.getElementById('autoLoginForm')?.submit()}
              >
                Login to Site 2
              </Button>
            </NavbarItem>

            <NavbarItem>
              <Dropdown placement="bottom-end">
                <DropdownTrigger>
                  <Avatar
                    isBordered
                    as="button"
                    className="transition-transform"
                    src={userProfile?.avatar}
                    name={userProfile?.name}
                  />
                </DropdownTrigger>
                <DropdownMenu aria-label="User menu">                
                  <DropdownItem
                    key="drafts"
                    startContent={<Edit3 size={16} />}
                  >
                    <Link to="/posts/drafts">My Drafts</Link>
                  </DropdownItem>
                  <DropdownItem
                    key="logout"
                    startContent={<LogOut size={16} />}
                    className="text-danger"
                    color="danger"
                    onPress={onLogout}
                  >
                    Log Out
                  </DropdownItem>
                </DropdownMenu>
              </Dropdown>
            </NavbarItem>
          </>
        ) : (
          <>
            <NavbarItem>
              <Button as={Link} to="/login" variant="flat">
                Log In
              </Button>
            </NavbarItem>
          </>
        )}
      </NavbarContent>

      <NavbarMenu>
        {menuItems.map((item) => (
          <NavbarMenuItem key={item.path}>
            <Link
              to={item.path}
              className={`w-full ${
                location.pathname === item.path
                  ? 'text-primary'
                  : 'text-default-600'
              }`}
              onClick={() => setIsMenuOpen(false)}
            >
              {item.name}
            </Link>
          </NavbarMenuItem>
        ))}
      </NavbarMenu>
    </Navbar>
  );
};

export default NavBar;